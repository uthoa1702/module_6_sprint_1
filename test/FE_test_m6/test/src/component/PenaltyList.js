import React, {useEffect, useState} from "react";
import 'bootstrap/dist/css/bootstrap.min.css'
import * as penaltyService from './service/PenaltyService'
import {Link} from "react-router-dom";
import {Field, Form, Formik} from "formik";
import * as Swal from "sweetalert2";

export const PenaltyList = () => {


    const [penalty, setPenalty] = useState([])
    const [page, setPage] = useState(0)
    const [totalPages, setTotalPage] = useState(0)
    const [playerName, setPlayerName] = useState("")


    const fetchApi = async () => {
        try {
            const res = await penaltyService.getList(page, playerName)
            await setPenalty(res.content)
            await setTotalPage(res.totalPages)

        }catch (e) {
            console.log(e)
        }
    }

    const deletePen = async (id, name) => {
        try {
            const deleteInfo = async () => {
                await Swal.fire({
                    icon: "warning",
                    title: "Ban co chac chan muon xoa " + name + " khong?",
                    showConfirmButton: true,
                    showCancelButton: true
                }).then(value =>{ if (value.isConfirmed){
                    penaltyService.remove(id)
                    Swal.fire({
                        icon: "success",
                        title: "Da xoa thanh cong " + name
                    })
                }})
            }
            await deleteInfo()
            await fetchApi()


        }catch (e) {
            console.log(e)
        }
    }

    useEffect(()=>{
        fetchApi()
    },[page, playerName])

    function paginate(page) {
       setPage(page)
    }

    return (
        <>
            <div className="row mx-2">
                <div className="container mx-auto my-5 col-12" style={{width: "100%"}}>
                    <div

                    >
                        <div style={{marginBottom: 20}}>
                            <h1
                                className="d-flex justify-content-center"
                                style={{padding: 16}}
                            >
                                Danh sách penalty
                            </h1>
                        </div>

                    </div>
                    <div className="table-hover, table-striped justify-content-center " style={{width: '100%'}}>

                        <Link to='/create'  className='btn btn-success'>
                            Them moi cau thu
                        </Link>
                        <Link to='/top5'  className='btn btn-primary'>
                           top 5 cau thu ghi nhieu ban nhat
                        </Link>
                        <Formik initialValues={{
                            name: playerName
                        }} onSubmit={(value)=>{
                            const res = async () => {
                                try {
                                    await setPlayerName(value.name)
                                    await setPage(0)
                                }catch (e) {
                                    console.log(e)
                                }
                            }
                            res()

                        }}>
                        <Form>


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
                                            name="name"
                                            className="form-control"
                                            placeholder={"Tên cau thu"}
                                        />
                                    </div>
                                </div>


                                <div className="col-lg-1">
                                    <div className="form-group">
                                        <button type="submit"
                                                className="btn btn-outline-success " style={{width: "auto"}}>Tim kiem
                                        </button>
                                    </div>
                                </div>


                            </div>
                            <br/>
                        </Form>
                        </Formik>
                        <table className="table table-striped ">
                            <thead>
                            <tr style={{textAlign: "start"}}>
                                <th>ID</th>
                                <th>Ten cau thu</th>
                                <th>Ten doi</th>

                                <th>Goc sut</th>
                                <th>Vao hay khong?</th>
                                <th>Chức năng</th>
                            </tr>
                            </thead>
                            {penalty?.length === 0  ? (
                                <td colSpan="10">
                                    <h4 className={"text-danger text-center my-3"}>
                                        Dữ liệu không tồn tại
                                    </h4>
                                </td>
                            ) : (
                                <tbody>
                                {penalty.map((list, index) => (
                                    <tr key={index}>
                                        <td>{list.id}</td>
                                        <td>{list.playerModel.name}</td>
                                        <td>{list.playerModel.teamModel.name}</td>

                                        <td>{list.area}</td>
                                        <td>{list.result ? 'Co' : 'Khong'}</td>
                                        <td><button onClick={() => deletePen(list.id, list.playerModel.name)} className="btn btn-danger">Xoa</button></td>
                                    </tr>
                                ))}
                                </tbody>
                            )}
                        </table>

                        {
                            penalty.length === 0 ? '' :
                                <div className="d-flex col-12 justify-content-end">
                                    <nav aria-label="...">
                                        <ul className="pagination">
                                            <li hidden={page === 0} className="page-item ">
                                                <button className="page-link " tabIndex={-1}
                                                        style={{border: "1px solid gray", borderRadius: "5px"}}

                                                        onClick={() => paginate(page - 1)}>
                                                    Trước
                                                </button>
                                            </li>


                                            {
                                                Array.from({length: totalPages}, (a, index) => index).map((pageNum) => (
                                                    <li className="page-item">
                                                        <button
                                                            className={page === pageNum ? "page-link-active" : "page-link"}
                                                            style={{border: "1px solid gray", borderRadius: "5px"}}
                                                            key={pageNum}
                                                            onClick={() => paginate(pageNum)}>
                                                            {pageNum + 1}
                                                        </button>
                                                    </li>
                                                ))
                                            }

                                            <li hidden={page + 1 === totalPages}
                                                className="page-item">
                                                <button className="page-link " tabIndex={-1}
                                                        style={{border: "1px solid gray", borderRadius: "5px"}}

                                                        onClick={() => paginate(page + 1)}>
                                                    Sau
                                                </button>
                                            </li>
                                        </ul>
                                    </nav>
                                </div>
                        }


                    </div>
                </div>
            </div>

        </>

    )
}