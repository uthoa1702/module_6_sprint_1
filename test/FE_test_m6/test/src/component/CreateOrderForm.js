import {ErrorMessage, input, Form} from "formik";
import React from "react";
import Modal from "bootstrap/js/src/modal";

export const CreateOrderForm = () => {




    return (
        <>
            <div className="container mt-5 mb-5">
                <div className="row  d-flex justify-content-center align-items-center">
                    <div className="col-md-6">
                        <div className="card px-5 py-4">
                            <div style={{textAlign: "center"}}>
                                <h3>Them moi don hang</h3>
                            </div>
                            <form>
                                <div className="mt-4 inputs">
                                    <label>Chon Khách Hàng</label>
                                    < select aria-label="Default select example"
                                           className="form-select" name='customerId'>
                                        <option value={0}>Chọn</option>
                                        {/*{*/}
                                        {/*    orders && orders.map((s) => (*/}
                                        {/*        <option key={s.id}*/}
                                        {/*                value={s.id}>{s.customer.nameCustomer}</option>*/}
                                        {/*    ))*/}
                                        {/*}*/}

                                    </select>
                                <div className="mt-2 inputs">
                                    <label>total</label>
                                    <input type="number" className="form-control" name='total'/>
                                    {/*<p style={{color: "red"}}>{total}</p>*/}
                                </div>
                                <div className="mt-2 inputs">
                                    <label>Start Date</label>
                                    <input type="date" className="form-control" name='startDate'/>
                                    {/*<p style={{color: "red"}}>{price}</p>*/}
                                </div>
                                <div className="mt-2 inputs">
                                    <label>End Date</label>
                                    <input type="date" className="form-control" name='endDate'/>
                                    {/*<p style={{color: "red"}}>{producer}</p>*/}

                                </div>

                                {/*<div className="mt-2 inputs">*/}
                                {/*    <label>Nội Dung - Ghi Chú</label>*/}
                                {/*    <input as="textarea" type="text" className="form-control"*/}
                                {/*           name='contentNote'/>*/}
                                {/*    <ErrorMessage className='form-err' component='span' name='contentNote'/>*/}
                                {/*    <p style={{color: "red"}}>{contentNote}</p>*/}

                                {/*</div>*/}
                                <div className="text-center mt-4 btn-group">
                                    <button type="submit" className=" btn btn-success integration">
                                        <b>Đăng ký</b>
                                    </button>
                                </  div>
                                </div>

                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <Modal

                className="modal-lg"
                show={showModal}
                onHide={handleModalClose}

                keyboard={false}
                centered
                >
                <Modal.Header style={{backgroundColor: "#00833e", color: "white"}}>
                <Modal.Title style={{width: "100%", textAlign: "center"}}>
                <b>Chọn khách hàng</b>
                </Modal.Title>
                <Button
                variant="secondary"
                className="btn-close"
                style={{marginLeft: 0}}
                onClick={handleModalClose}
                />
                </Modal.Header>
                <Modal.Body>
                <div className="controlsmodal-body d-flex justify-content-between">

                </div>
                <table className="table table-striped">
                <thead>
                <tr style={{textAlign: "start"}}>
                <th className="">STT</th>
                <th className="">Tên khách hàng</th>
                <th className="text-center">Chức Năng</th>
                </tr>
                </thead>
                {customer.length === 0 ?
                    <tr>
                        <td colSpan="4" className="text-center">
                            <h4 style={{color: "red"}}>Dữ liêu không tồn tại</h4>
                        </td>
                    </tr>
                    :
                    <tbody>
                    {customer.map((list, index) => (
                        <tr key={index}>
                            <td>{list.id}</td>
                            <td className=" ">{list.names}</td>
                            <td className="text-center">
                                <button onClick={() => {

                                    handleModalClose(true);
                                }} className="btn btn-success text-center">
                                    Chọn
                                </button>
                            </td>
                        </tr>
                    ))
                    }
                    {/* Other table rows */}
                    </tbody>
                }
                </table>
                </Modal.Body>


            </Modal>
        </>
    )
}