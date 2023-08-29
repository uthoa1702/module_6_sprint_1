import * as playerService from './service/PlayerService'
import {ErrorMessage, Field, Form, Formik} from "formik";
import React, {useEffect, useState} from "react";
import * as yup from 'yup'
import * as Swal from "sweetalert2";
import {useNavigate} from "react-router-dom";


export const CreatePlayer = () => {

    const [teams, setTeams] = useState([])

    const navigate = useNavigate()

    const fetchApi = async () => {
        const res = await playerService.getTeamList()
        await setTeams(res)
    }

    useEffect(() => {
        fetchApi()
    }, [])


    console.log("danh sach team " + teams)

    return (
        <>
            <div className="container mt-5 mb-5">
                <div className="row  d-flex justify-content-center align-items-center">
                    <div className="col-md-6">
                        <div className="card px-5 py-4">
                            <div style={{textAlign: "center"}}>
                                <h3>Them moi cau thu</h3>
                            </div>
                            <Formik initialValues={{
                                name: '',
                                birthday: '',
                                teamModel: ''
                            }}
                                    validationSchema={yup.object({
                                        name: yup.string().required("bat buoc nhap").matches(/^[^!@#$%^&*()+=\[\]{};':"\\|.<>?`~/]+$/, "Tên không chứa ký tự đặc biệt như @#$.."),
                                        birthday: yup.date().required('bat buoc nhap').test("is-over-16", "Bạn chưa đủ 16 tuổi ", function (value) {
                                            const currentDate = new Date();
                                            const selectedDate = new Date(value);
                                            const ageDiff =
                                                currentDate.getFullYear() - selectedDate.getFullYear();
                                            return ageDiff > 16;

                                        }),
                                        teamModel: yup.string().required("bat buoc phai chon")
                                    })}
                                    onSubmit={(values) => {
                                        const res = async () => {
                                            try {
                                                await playerService.save(values)

                                            } catch (e) {
                                                console.log(e)
                                            }
                                        }
                                        res().then(() => {
                                            navigate("/")
                                            Swal.fire({
                                                icon: "success",
                                                title: 'Ban da them moi thanh cong ' + values.name

                                            })
                                        }).catch(() => {
                                            Swal.fire({
                                                icon: "error"
                                            })
                                        })
                                    }}>

                                <Form>
                                    <div className="mt-4 inputs">
                                        <Field as='select' aria-label="Default select example"
                                               className="form-select" name='teamModel'>
                                            <option value={''}>Chọn doi</option>
                                            {
                                                teams && teams.map((s) => (
                                                    <option key={s.id}
                                                            value={s.id}>{s.name}</option>
                                                ))
                                            }

                                        </Field>
                                        <ErrorMessage name='teamModel' className='form-err' component='span'/>


                                    </div>
                                    <div className="mt-2 inputs">
                                        <label>Ten cau thu</label>
                                        <Field type="text" className="form-control" name='name'/>
                                        <ErrorMessage name='name' className='form-err' component='span'/>

                                    </div>
                                    <div className="mt-2 inputs">
                                        <label>Ngay sinh</label>
                                        <Field type="date" className="form-control" name='birthday'/>
                                        <ErrorMessage name='birthday' className='form-err' component='span'/>

                                    </div>


                                    <div className="text-center mt-4 btn-group">
                                        <button type="submit" className=" btn btn-success integration">
                                            <b>Đăng ký</b>
                                        </button>
                                    </div>
                                </Form>
                            </Formik>

                        </div>
                    </div>
                </div>
            </div>
        </>
    )
}