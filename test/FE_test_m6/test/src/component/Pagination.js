import React, {useEffect, useState} from "react";
import * as orderService from "./service/OrderService";


export const Pagination = () => {
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

            {
                orders.length === 0 ? '' :
                    <div className="d-flex col-12 justify-content-end">
                        <nav aria-label="...">
                            <ul className="pagination">
                                <li hidden={page === 0} className="page-item ">
                                    <button className="page-link page-link-khanhh" tabIndex={-1}
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
                                    <button className="page-link page-link-khanhh" tabIndex={-1}
                                            style={{border: "1px solid gray", borderRadius: "5px"}}

                                            onClick={() => paginate(page + 1)}>
                                        Sau
                                    </button>
                                </li>
                            </ul>
                        </nav>
                    </div>
            }
            </>
    )
}