import {Field, Form, Formik} from "formik";
import React, {useEffect, useState} from "react";
import * as contractService from '../../service/ContractService';
import {Link} from "react-router-dom";
import * as Swal from "sweetalert2";

export default function TransactionHistoryList() {
    const [contractStatus, setContractStatus] = useState([])
    const [contractType, setContractType] = useState([])
    const [contracts, setContract] = useState([]);
    const [page, setPage] = useState(0);
    const [totalPages, setTotalPages] = useState(0);
    const [deleteTHList, setDeleteTHList] = useState("");
    const getContractStatusApi = async () => {
        const res = await contractService.findAllContractStatus();
        setContractStatus(res)
    }
    const getContractTypeApi = async () => {
        const res = await contractService.findAllContractType();
        setContractType(res)
    }

    const paginate = (page) => {
        setPage(page)
    }
    const searchTH = async () => {
        try {
            const response = await contractService.searchTransactionHistory(page, search)
            await setContract(response.content)
            await setTotalPages(response.totalPages)
        } catch (error) {
            console.log(error);
        }
    };

    let [search, setSearch] = useState({
        customerName: '',
        productName: '',
        startDate: '',
        endDate: '',
        contractType: '',
        contractStatus: ''
    });


    useEffect(() => {
        getContractStatusApi();
        getContractTypeApi();
        searchTH();
    }, [search, page]);


    const deleteTransactionHistory = async (id) => {
        let res = await contractService.deleteTransactionHistoryByID(id);
        result(res.data)
        searchTH()
    }
    const result = (res) => {
        if (res != null) {
            if (res) {
                Swal.fire({
                    icon: "success",
                    title: "Xóa thành công !",
                    timer: 3000
                })
            } else {
                Swal.fire({
                    icon: "error",
                    title: "Xóa thất bại !",
                    timer: 3000
                })

            }
        }
    }
    return (
        <>
            <div className="col-lg-9 col-md-12 ">
                <div className="row">
                    <div className="col-lg-12 col-md-12">
                        <h1 className="text-center my-5">Lịch sử giao dịch</h1>
                        <Formik initialValues={({
                            customerName: search?.customerName,
                            productName: search?.productName,
                            startDate: search?.startDate,
                            endDate: search?.endDate,
                            contractType: search?.contractType,
                            contractStatus: search?.contractStatus
                        })}
                                onSubmit={(values) => {
                                    const res = async () => {
                                        await setPage(0)
                                        await contractService.searchTransactionHistory(page,values)
                                        await setSearch(values)
                                    }
                                    res()
                                    searchTH()
                                }}
                        >
                            <Form>
                                <div className="row justify-content-center">
                                    <div className=" col-lg-5 col-xl-5 col-md-5">
                                        <label htmlFor="customerName" className="form-label me-2"
                                               style={{color: "black"}}>Tên
                                            khách
                                            hàng:</label>
                                        <Field style={{borderColor: "black"}} type="text" id="customerName"
                                               className="form-control"
                                               name="customerName"/>
                                    </div>
                                    <div className="col-lg-5 col-xl-5 col-md-5">
                                        <label htmlFor="productName" className="form-label me-2"
                                               style={{color: "black"}}>Tên
                                            đồ:</label>
                                        <Field style={{borderColor: "black"}} type="text" id="productName"
                                               className="form-control"
                                               name="productName"/>
                                    </div>
                                </div>
                                <div className="row d-flex justify-content-center mt-3">
                                    <div className="col-lg-5 col-xl-5 col-md-5">
                                        <label htmlFor="startDate" className="form-label me-2"
                                               style={{color: "black"}}>Giao dịch từ
                                            ngày:</label>
                                        <Field style={{borderColor: "black"}} type="date" id="startDate"
                                               className="form-control"
                                               name="startDate"/>
                                    </div>
                                    <div className="col-lg-5 col-xl-5 col-md-5">
                                        <label htmlFor="endDate" className="form-label me-2"
                                               style={{color: "black"}}>Đến:</label>
                                        <Field style={{borderColor: "black"}} type="date" id="endDate"
                                               className="form-control"
                                               name="endDate"/>
                                    </div>
                                </div>
                                <div className="row d-flex justify-content-center align-items-center mt-3">
                                    <div className="col-lg-5 col-xl-5 col-md-5">
                                        <label className="form-label" style={{color: "black"}}>Loại hợp
                                            đồng:</label>
                                        <Field style={{borderColor: "black"}} name="contractType" as="select"
                                                className="text-center form-select">
                                            <option value={""}>--Chọn loại hợp đồng--</option>
                                            {
                                                contractType.map((ct, index) => (
                                                    <option key={index} value={ct?.id}>{ct?.name}</option>
                                                ))}
                                        </Field>
                                    </div>
                                    <div className="col-lg-5 col-xl-5 col-md-5">
                                        <div className="align-items-center">
                                            <label className="form-label" style={{color: "black"}}>Trạng
                                                thái: </label>
                                            <div className="d-flex">
                                                <Field style={{borderColor: "black"}} name="contractStatus" as="select"
                                                        className="text-center form-select me-2">
                                                    <option value={""}>--Chọn trạng thái--</option>
                                                    {
                                                        contractStatus.map((cs, index) => (
                                                            <option key={index} value={cs?.id}>{cs?.name}</option>
                                                        ))}
                                                    
                                                </Field>
                                                <button type="submit" className="btn btn-outline-primary">
                                                    <i className="bi bi-search"></i>
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </Form>
                        </Formik>

                    </div>
                </div>
            </div>
            <div className="row mt-5">
                <div className="col-lg-12">
                    <div>
                    <Link to={"/contract/create-contract"} className="btn btn-success ms-4 my-4 align-content-center">Thêm mới hợp đồng</Link>
                    </div>
                    <table className="table table table-striped text-center" border="1">
                        <thead>
                        <tr>
                            <th>Mã HD</th>
                            <th>Tên đồ</th>
                            <th>Tên khách hàng</th>
                            <th>Ngày làm HD (dd-mm-yyyy)</th>
                            <th>Loại hợp đồng</th>
                            <th>Trạng thái</th>
                            <th>Chức năng</th>
                        </tr>
                        </thead>
                        <tbody>
                        {
                            contracts.length>0?
                            contracts.map((th, index) => (
                                    <tr key={index}>
                                        <td>{th.contractCode}</td>
                                        <td>{th.productName}</td>
                                        <td>{th.customers}</td>
                                        <td>{th.startDate}</td>
                                        <td>{th.contractType}</td>
                                        <td>{th.contractStatus}</td>
                                        <td>
                                            <Link to={`/nav/info-store/transaction-history/detail/${th?.contractCode}`}><i
                                                className="bi bi-info-circle me-2"></i></Link>
                                            <Link to={""}
                                                  className="me-2"><i style={{color: "orange"}}
                                                                      className="bi bi-pencil-square"></i></Link>
                                            <a type="button" data-bs-toggle="modal"
                                               data-bs-target="#exampleModal" onClick={() => {
                                                setDeleteTHList(th?.contractCode)
                                            }}><i
                                                style={{color: "red"}}
                                                className="bi bi-trash3"></i></a>
                                        </td>
                                    </tr>
                                )
                            ):
                                <tr>
                                    <td colSpan="7">
                                        <div align="center">
                                            <h1>Không tìm thấy</h1>
                                        </div>
                                    </td>
                                </tr>
                        }

                        </tbody>
                    </table>
                </div>
            </div>
            <div className="row mt-3">
                <div className="d-flex col-12 justify-content-end">
                    <nav aria-label="..." className="me-4">
                        <ul className="pagination">
                            <li hidden={page === 0} className="page-item">
                                <button className="page-link" tabIndex={-1}
                                        onClick={() => paginate(page - 1)}>
                                    Trước
                                </button>
                            </li>
                            {
                                Array.from({length: totalPages}, (a, index) => index).map((pageNum) => (
                                    <li className="page-item" key={pageNum}>
                                        <button
                                            className={page === pageNum ? "active page-link" : "page-link"}
                                            key={pageNum}
                                            onClick={() => {
                                                paginate(pageNum)
                                            }}>
                                            {pageNum + 1}
                                        </button>
                                    </li>
                                ))
                            }

                            <li hidden={page + 1 === totalPages}
                                className="page-item">
                                <button className="page-link" tabIndex={-1}
                                        onClick={() => paginate(page + 1)}>
                                    Tiếp
                                </button>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
            {/* Modal */}
            <div className="modal fade" id="exampleModal"
                 data-bs-backdrop="static" data-bs-keyboard="false" tabIndex={-1}
                 aria-labelledby="staticBackdropLabel" aria-hidden="true">
                <div className="modal-dialog">
                    <div className="modal-content">
                        <div className="modal-header">
                            <h5 className="modal-title"
                                id="staticBackdropLabel6">Xác nhận
                                xóa lịch sử giao dịch</h5>
                            <button type="button" className="btn-close"
                                    data-bs-dismiss="modal" aria-label="Close"/>
                        </div>
                        <div className="modal-body">

                            <span>Bạn muốn xóa lịch sử giao dịch có mã code </span><span
                            style={{color: 'red'}}>{deleteTHList}</span><span> ?</span>
                        </div>
                        <div className="modal-footer">
                            <button type="button" className="btn btn-secondary"
                                    data-bs-dismiss="modal">Thoát
                            </button>
                            <button type="button" className="btn btn-danger"
                                    data-bs-dismiss="modal"
                                    onClick={() => {
                                        deleteTransactionHistory(deleteTHList);
                                    }}
                            >Xóa
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </>
    );
}