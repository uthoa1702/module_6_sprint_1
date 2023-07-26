import {useNavigate} from "react-router";
import React, {useEffect, useState} from "react";
import * as service from "../service/ProductService"
import {ErrorMessage, Field, Form, Formik} from "formik";
import * as Yup from "yup"
import sweat from "sweetalert2"
import 'bootstrap/dist/css/bootstrap.min.css';
import "./create.css"
export function Create() {

    const navigate = useNavigate();
    const [orders, setOrders] = useState([]);
    const [page, setPage] = useState(0);



    useEffect(() => {
        const getAllCustomer = async () => {
            const res = await service.getAll(page)
            setOrders(res.content)
        }
        getAllCustomer()
    }, [])
    if (!orders) {
        return null
    }

    return (
        <>

            <Formik initialValues={{
                total : 0,
                startDate :"",
                endDate :"",
                customerId : 0

            }}
                    validationSchema={Yup.object({
                        total: Yup.number().required("bạn không không thể để trống"),
                        startDate: Yup.string().required("bạn không không thể để trống"),
                        endDate: Yup.string().required("bạn không không thể để trống"),
                        customerId: Yup.number().required("bạn không không thể để trống").min(1,"giá tiền không thể nhỏ hơn  0"),
                    })}
                    onSubmit={(values ,{resetForm}) =>{
                        console.log(values)
                        const create = async () => {
                            const serviceCurrent = orders.find(item => item.id === Number(values.customerId));
                            const {customerId, ...body} = values;
                            await service.save({
                                ...body,
                                customer: serviceCurrent
                            })

                            // if(value && value?.status !== 200){
                            //     setName(value.response.data.name)
                            //     setPrice(value.response.data.price)
                            //     setProducer(value.response.data.producer)
                            //     setDate(value.response.data.date)
                            //     setAmount(value.response.data.amount)
                            // }
                            // else {
                            await sweat.fire({
                                icon: "success",
                                title: `thêm mới  ${values.name} thành công !!!`,
                                timer: "2000"
                            })
                            resetForm();
                            navigate("/")
                            //     }
                            // }
                        }
                        create()
                    }}>
                {
                    <div className="container mt-5 mb-5">
                        <div className="row  d-flex justify-content-center align-items-center">
                            <div className="col-md-6">
                                <div className="card px-5 py-4">
                                    <div style={{textAlign: "center"}}>
                                        <h3>Create</h3>
                                    </div>
                                    <Form>
                                        <div className="mt-4 inputs">
                                            <label>Chon Khách Hàng</label>
                                            <Field as='select' aria-label="Default select example"
                                                   className="form-select" name='customerId'>
                                                <option value={0}>Chọn</option>
                                                {
                                                    orders && orders.map((s) => (
                                                        <option key={s.id}
                                                                value={s.id}>{s.customer.nameCustomer}</option>
                                                    ))
                                                }

                                            </Field>
                                            <ErrorMessage className='form-err' component='span'
                                                          name='customerId'/>
                                        </div>
                                        <div className="mt-2 inputs">
                                            <label>total</label>
                                            <Field type="number" className="form-control" name='total'/>
                                            <ErrorMessage className='form-err' component='span' name='total'/>
                                            {/*<p style={{color: "red"}}>{total}</p>*/}
                                        </div>
                                        <div className="mt-2 inputs">
                                            <label>Start Date</label>
                                            <Field type="date" className="form-control" name='startDate'/>
                                            <ErrorMessage className='form-err' component='span' name='startDate'/>
                                            {/*<p style={{color: "red"}}>{price}</p>*/}
                                        </div>
                                        <div className="mt-2 inputs">
                                            <label>End Date</label>
                                            <Field type="date" className="form-control" name='endDate'/>
                                            <ErrorMessage className='form-err' component='span' name='endDate'/>
                                            {/*<p style={{color: "red"}}>{producer}</p>*/}

                                        </div>

                                        {/*<div className="mt-2 inputs">*/}
                                        {/*    <label>Nội Dung - Ghi Chú</label>*/}
                                        {/*    <Field as="textarea" type="text" className="form-control"*/}
                                        {/*           name='contentNote'/>*/}
                                        {/*    <ErrorMessage className='form-err' component='span' name='contentNote'/>*/}
                                        {/*    <p style={{color: "red"}}>{contentNote}</p>*/}

                                        {/*</div>*/}
                                        <div className="text-center mt-4 btn-group">
                                            <button type="submit" className=" btn btn-success integration">
                                                <b>Đăng ký</b>
                                            </button>
                                        </div>
                                    </Form>
                                </div>
                            </div>
                        </div>
                    </div>
                }
            </Formik>

        </>
    )

}