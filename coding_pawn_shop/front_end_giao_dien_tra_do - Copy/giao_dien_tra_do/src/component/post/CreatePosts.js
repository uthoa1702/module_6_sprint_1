import * as servicePosts from "../../service/ServicePosts";
import React, {useEffect, useState} from "react";
import "../../css/Posts.css";
import {ErrorMessage, Field, Form, Formik} from "formik";
import * as Yup from "yup";
import {useNavigate} from "react-router";
import {NavLink} from "react-router-dom";
import {getDownloadURL, ref, uploadBytesResumable} from "firebase/storage";
import {storage} from "../../firebasePosts";
import Swal from "sweetalert2";

export function CreatePosts() {
    const navigate = useNavigate()
    const [employees, setEmployees] = useState([])

    const [selectedFile, setSelectedFile] = useState(null);
    const [firebaseImg, setImg] = useState(null);
    const [progress, setProgress] = useState(0);
    const [imgErr, setImgErr] = useState("");

    const handleFileSelect = (event) => {
        const file = event.target.files[0];
        setImgErr("");
        if (file) {
            setSelectedFile(file);
        }
    };
    const getIdEmployee = (id) => {
        for (let e of employees) {
            if (e.id === id) {
                return e
            }
        }
    }

    const save = () => {
        Swal.fire({
            position: 'center',
            icon: 'success',
            title: 'Thêm mới tin thành công ',
            showConfirmButton: false,
            timer: 1500
        })
    }

    const handleSubmitAsync = async () => {
        return new Promise((resolve, reject) => {
            const file = selectedFile;
            if (!file) return reject("Chưa có file nào được chọn ");
            const storageRef = ref(storage, `files/${file.name}`);
            const uploadTask = uploadBytesResumable(storageRef, file);

            uploadTask.on(
                "state_changed",
                (snapshot) => {
                    const progress = Math.round(
                        (snapshot.bytesTransferred / snapshot.totalBytes) * 100
                    );
                    setProgress(progress);
                },
                (error) => {
                    reject(error);
                },
                async () => {
                    const downloadURL = await getDownloadURL(uploadTask.snapshot.ref);
                    setImg(downloadURL);
                    resolve(downloadURL);
                }
            );
        });
    };
    useEffect(() => {
        const findAllEmployees = async () => {
            const result = await servicePosts.findAllEmployees()
            setEmployees(result)
        }
        findAllEmployees()
    }, [])

    return (
        <>
            <div className="container mt-5 d-flex justify-content-center">
                <div className="card">
                    <Formik initialValues={{title: '', content: '', createDate: new Date(), image: '', employees: ''}}
                            validationSchema={Yup.object({
                                title: Yup.string().required("Bắt buộc nhập"),
                                content: Yup.string().required("Bắt buộc nhập")
                            })}

                            onSubmit={(values, {resetForm}) => {
                                const create = async () => {
                                    const newValue = {
                                        ...values,
                                        image: firebaseImg,
                                        employees:getIdEmployee(+values.employees)
                                    };
                                    newValue.image = await handleSubmitAsync();
                                    try {

                                        await servicePosts.createPosts(
                                            { ...newValue,
                                                image: newValue.image}
                                        );
                                        save();
                                        navigate("/");
                                        resetForm(false);
                                    } catch (e) {
                                        resetForm(true);
                                    }
                                };

                                create();



                            }}
                    >
                        <Form>
                            <h2 className="d-flex justify-content-center"
                                style={{
                                    padding: "10px",
                                    height: "60px",
                                    backgroundColor: "#00833e",
                                    color: "#fff",
                                    display: "flex"
                                }}>
                                <b>THÊM TIN TỨC MỚI</b>
                            </h2>
                            <div className="row">
                                <div className="col-lg-7">
                                    <div className="form-group ms-2">
                                        <label htmlFor="title" className="form-label">Tiêu đề <span
                                            className="err-class">*</span></label>
                                        <Field id="title" type="text" name="title" className="form-control"
                                               placeholder="Nhập tiêu đề tin tức"/>
                                        <ErrorMessage name="title" component="span" className="err-class"/>
                                    </div>
                                    <div className="form-group mt-2 ms-2">
                                        <label htmlFor="content">Nội dung <span className="err-class">*</span></label>
                                        <Field as="textarea" id="content" name="content"
                                               placeholder="Nhập nội dung tin tức" rows="15"/>
                                        <ErrorMessage name="content" component="span" className="err-class"/>
                                    </div>
                                    <div className="mt-2 ms-2">
                                        <label htmlFor="createDate" className="form-label">Ngày đăng</label>
                                        <Field id="createDate" name="createDate" className="form-control"/>
                                    </div>
                                    <div className="mt-2 ms-2">
                                        <label htmlFor="employees"> Nhân viên</label>
                                        <Field id="employees" name="employees" as="select">
                                            <option value="0">Chọn</option>
                                            {
                                                employees.map((items, index) => (
                                                    <option key={index} value={items.id}>{items.name}</option>
                                                ))
                                            }
                                        </Field>
                                    </div>
                                </div>
                                <div className="col-lg-5">
                                    <div className="col-lg-12">
                                        <div
                                            className="column-gap-lg-3"
                                            style={{width: "92%", marginBottom: "5%", marginLeft: "3%"}}
                                        >
                                            {selectedFile && (
                                                <img
                                                    className={"mt-2"}
                                                    src={URL.createObjectURL(selectedFile)}
                                                    style={{width: "100%"}}
                                                    alt=""/>
                                            )}
                                        </div>
                                        <div className="form-outline">
                                            <Field
                                                type="file"
                                                onChange={(e) => handleFileSelect(e)}
                                                id="image"
                                                name={"image"}
                                                className="form-control-plaintext d-none "
                                            />
                                            <p>
                                                <label
                                                    htmlFor="image"
                                                    style={{
                                                        textAlign: "center",
                                                        // display: "flex",
                                                        padding: "6px 12px",
                                                        border: "1px solid",
                                                        borderRadius: "4px",
                                                        marginLeft: "3%",
                                                        marginRight: "5%"
                                                    }}
                                                >Chọn hình ảnh
                                                </label>
                                            </p>
                                            {!selectedFile && (
                                                <span className={"mt-2 text-danger"}>Chưa có hình ảnh được chọn
                                                </span>
                                            )}
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div className="d-flex justify-content-center">
                                <div className="text-center mt-4 btn-group">
                                    <button className="btn btn-secondary integration mb-3">
                                        <NavLink className="text-bg-secondary text-decoration-none" to={"/"}>
                                            <b>Quay lại</b>
                                        </NavLink>
                                    </button>
                                </div>
                                <div className="text-center mt-4 ms-3 btn-group">
                                    <button type="submit" className="btn btn-success integration mb-3">
                                        <b>Đăng bài</b>
                                    </button>
                                </div>
                            </div>
                        </Form>
                    </Formik>
                </div>
            </div>
        </>
    )
}