import React, {useEffect, useState} from "react";
import 'bootstrap/dist/css/bootstrap.min.css'
import * as orderService from './service/OrderService.js'
import {Routes, Route} from 'react-router-dom'
import {Pagination} from "./Pagination";
import {CreateButton} from "./CreateButton";




export const OrderList = () => {
    const [orders, setOrders] = useState([])
    const [page, setPage] = useState(0)
    const [totalPages, setTotalPage] = useState(0)


    const fetchApi = async () => {
        try {
            const res = await orderService.getOrderList(page)
            await setOrders(res.content)
            await setTotalPage(res.totalPages)
        }catch (e) {
            console.log(e)
        }
    }

    function paginate(pageNum) {
       setPage(pageNum )
    }

    useEffect(() => {
        fetchApi()
    },[page])

    return (
        <>
            <div className="row mx-0">
                <div className="container mx-auto my-5 col-8" style={{width: "90%"}}>
                    <div

                    >
                        <div style={{marginBottom: 20}}>
                            <h1
                                className="d-flex justify-content-center"
                                style={{padding: 16}}
                            >
                                Danh sách đặt hàng
                            </h1>
                        </div>

                    </div>
                    <div className="table-responsive justify-content-center " style={{width: '100%'}}>
                        <CreateButton/>
                        <table className="table table-striped ">
                            <thead>
                            <tr style={{textAlign: "start"}}>
                                <th>ID</th>
                                <th>Khách hàng</th>
                                <th>Thời gian</th>

                                <th>Tổng tiền</th>
                                <th>Chức năng</th>
                            </tr>
                            </thead>
                            {orders?.length === 0  ? (
                                <td colSpan="10">
                                    <h4 className={"text-danger text-center my-3"}>
                                        Dữ liệu không tồn tại
                                    </h4>
                                </td>
                            ) : (
                                <tbody>
                                {orders.map((list, index) => (
                                    <tr key={index}>
                                        <td>{list.id}</td>
                                        <td>{list.customerName}</td>
                                        <td>{list.amount}</td>

                                        <td>{list.total}</td>
                                        <td><button className="btn btn-primary">Chi tiết</button></td>
                                    </tr>
                                ))}
                                </tbody>
                            )}
                        </table>

                          <Pagination />


                    </div>
                </div>
            </div>
        </>
    )
}