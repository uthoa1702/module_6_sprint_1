import React, {useEffect, useState} from "react";
import {Modal} from "react-bootstrap";

import * as showAllContractService from '../service/ShowAllContractServices'
import {Field, Form, Formik} from "formik";

export const ShowContract = () => {
    const [showModal, setShowModal] = useState(false);
    const [page, setPage] = useState(0);
    const [totalPage, setTotalPage] = useState(0);
    const [searchName, setSearchName] = useState('');
    const [searchType, setSearchType] = useState('');
    const [showDetail, setShowDetail] = useState(0);
    const [contracts, setContracts] = useState([]);
    const [typeProduct, setProductType] = useState([]);

    const fetchAPI = () => {
        const rs = async () => {
            try {
                const r = await showAllContractService.getAllContractPage(page, searchName, searchType)
                console.log("contract ..." + r.content)
                await setContracts(r.content)
                const type = await showAllContractService.getProductTypeList();
                await setProductType(type)

            } catch (e) {
                console.log(e)
            }
        }
        rs()
    }
    const getTypeId = (id) => {
        setSearchType(id)
    }

    useEffect(() => {
        fetchAPI(page, contracts)
    }, [])

    console.log("loai do" + searchType)

    const handleShowDetail = async (id) => {
        await setShowDetail(id)
        await setShowModal(true)
    }
    console.log("id cua contract: " + searchName)
    return (
        <>

            <meta charSet="UTF-8"/>
            <title>Title</title>
            <link
                href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
                rel="stylesheet"
                integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
                crossOrigin="anonymous"
            />
            <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"/>
            <link
                rel="stylesheet"
                href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css"
            />
            <style
                dangerouslySetInnerHTML={{
                    __html:
                        '\n        @import url("https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800&display=swap");\n\n        .card {\n            border: none;\n            padding: 20px;\n            position: relative;\n            background-color: rgba(255, 255, 255, 0.7);\n            border-radius: 20px;\n        }\n\n        body {\n        }\n\n        body {\n            background-color: #eee;\n            font-family: "Poppins", sans-serif;\n            font-weight: 300\n        }\n\n        .height {\n            height: 100vh\n        }\n\n        .card {\n            border: none;\n            padding: 20px;\n            position: relative\n        }\n\n        .btn-group {\n            display: flex;\n            justify-content: space-between;\n        }\n\n        label {\n            font-family: Arial, sans-serif;\n            font-size: 14px;\n            font-weight: bold;\n            color: #222222;\n            margin-bottom: 5px;\n            display: inline-block;\n        }\n\n    '
                }}
            />
            <br/>
            <div className="modal-content">
                <div className="d-flex">
                    <div className="modal-body">
                        <div>

                            <Formik initialValues={{
                                productName: searchName,
                                typeProduct: searchType
                            }} onSubmit={
                                (values) => {
                                    const res = async () => {
                                        await setSearchName(values.productName)
                                        await setSearchType(values.productType)
                                                await setPage(0)
                                    }

                                    res()
                                    fetchAPI()
                                }
                            }>
                                <Form action="" className="controls">
                                    <div
                                        className="row"
                                        style={{display: "flex", justifyContent: "end"}}
                                    >
                                        <div className="col-lg-3">
                                            <div className="form-group">
                                                <Field
                                                    style={{borderColor: "black"}}
                                                    id=""
                                                    type="text"
                                                    name="productName"
                                                    className="form-control"
                                                />
                                            </div>
                                        </div>

                                        <div className="col-lg-3">
                                            <div className="form-group">
                                                <Field onClick={(event)=>{
                                                    getTypeId(event.target.value)
                                                }}
                                                    style={{borderColor: "black"}}
                                                    id="doCam"
                                                    as="select"
                                                    name="typeProduct"
                                                    className="form-control"

                                                >
                                                    <option value=''>Chọn loại đồ</option>

                                                    {
                                                        typeProduct && typeProduct.map((value) => (
                                                            <option key={value.id} value={value.id}>{value.name}</option>

                                                        ))
                                                    }
                                                </Field>
                                            </div>
                                        </div>
                                        <div className="col-lg-1">
                                            <div className="form-group">
                                                <button type="submit" className="btn btn-outline-primary ">
                                                    <i className="bi bi-search"/>
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                    <br/>
                                </Form>

                            </Formik>
                        </div>
                        <div>
                            <table className="table table-striped">
                                <thead>
                                <tr className="text-center">
                                    <th>Mã hợp đồng</th>
                                    <th>Tên đồ</th>
                                    <th>Loại đồ</th>
                                    <th>Trạng thái</th>
                                    <th>Giá mua(VND)</th>
                                    <th>Hành động</th>
                                </tr>
                                </thead>
                                <tbody>
                                {
                                    contracts && contracts.map((value) => (
                                        <tr key={value.contractId} className="text-center">
                                            <td>{value.contractCode}</td>
                                            <td>{value.productName}</td>
                                            <td>{value.productType}</td>
                                            <td>{value.contractStatus}</td>
                                            <td>{value.loans}</td>
                                            <td>
                                                <button className="btn btn-sm btn-info" data-bs-toggle="modal"
                                                        data-bs-target="#staticBackdrop"
                                                        onClick={() => handleShowDetail(value.contractId)}>Chi
                                                    tiết
                                                </button>

                                            </td>
                                        </tr>
                                    ))
                                }

                                </tbody>
                            </table>
                            <div className="d-flex col-12 justify-content-end">
                                <nav aria-label="...">
                                    <ul className="pagination">
                                        <li className="page-item disabled">
                                            <a
                                                className="page-link"
                                                href="#"
                                                tabIndex={-1}
                                                aria-disabled="true"
                                            >
                                                Trước
                                            </a>
                                        </li>
                                        <li className="page-item active" aria-current="page">
                                            <a className="page-link" href="#">
                                                1
                                            </a>
                                        </li>
                                        <li className="page-item ">
                                            <a className="page-link" href="#">
                                                2
                                            </a>
                                        </li>
                                        <li className="page-item">
                                            <a className="page-link" href="#">
                                                3
                                            </a>
                                        </li>
                                        <li className="page-item">
                                            <a className="page-link" href="#">
                                                Sau
                                            </a>
                                        </li>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


            <Modal
                show={showModal} onHide={() => setShowModal(false)}
                className="modal fade bd-example-modal-lg"
                id="staticBackdrop"
                data-bs-backdrop="static"
                data-bs-keyboard="false"
                tabIndex={-1}
                aria-labelledby="staticBackdropLabel"


            >
                <div className="modal-dialog  modal-dialog-centered modal-xl">
                    <div className="modal-content">
                        <div className="modal-header" align="center">
                            <h1 className="modal-title text-center align-content-center" id="staticBackdropLabel"><b>
                                {" "}
                                Chi tiết đồ cầm{" "}
                            </b>

                            </h1>
                            <button
                                type="button"
                                className="btn-close"
                                data-bs-dismiss="modal"
                                aria-label="Close"
                                onClick={() => setShowModal(false)}
                            />
                        </div>
                        <div className="row mb-4 mt-4 ">
                            <div className="col-md-4  ">
                                <div className=" image-frame col-sl-12">
                                    <div className="card-body ">
                                        <img
                                            src="https://product.hstatic.net/200000281285/product/sh_160_tieu_chuan_do_den_5b652c376c47418f801bde61462e4a52_large.png"
                                            width={"100%"}
                                            alt=""
                                        />
                                    </div>
                                </div>
                            </div>
                            <div className="col-md-8" style={{width: "63.666667%"}}>
                                <div className="">
                                    <div className="card-body ">
                                        <table className="table table-bordered">
                                            <tbody>
                                            <tr className="row">
                                                <th className="col-sm-6"> Mã khách hàng</th>
                                                <td className="col-sm-6"> kh123</td>
                                            </tr>
                                            <tr className="row">
                                                <th className="col-sm-6"> Mã hợp đồng</th>
                                                <td className="col-sm-6"> HD1234</td>
                                            </tr>
                                            <tr className="row">
                                                <th className="col-sm-6"> Tên khách hàng</th>
                                                <td className="col-sm-6"> Trung</td>
                                            </tr>
                                            <tr className="row">
                                                <th className="col-sm-6"> Tên đồ cầm</th>
                                                <td className="col-sm-6"> xe SH 2019</td>
                                            </tr>
                                            <tr className="row">
                                                <th className="col-sm-6"> Loại đồ</th>
                                                <td className="col-sm-6"> xe may</td>
                                            </tr>
                                            <tr className="row">
                                                <th className="col-sm-6">Giá mua</th>
                                                <td className="col-sm-6"> 50.000.000 VND</td>
                                            </tr>
                                            <tr className="row">
                                                <th className="col-sm-6"> Ngày bắt đầu</th>
                                                <td className="col-sm-6">16/02/2023</td>
                                            </tr>
                                            <tr className="row">
                                                <th className="col-sm-6">Ngày kết thúc</th>
                                                <td className="col-sm-6">16/03/2023</td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </Modal>

        </>


    )
}