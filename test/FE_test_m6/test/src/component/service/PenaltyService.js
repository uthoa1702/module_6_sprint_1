import axios from "axios";

export const getList = async (page, name) => {
    try {
        const res = await axios.get("http://localhost:8080/penalty/list?name=" + name + "&page=" + page)
        return res.data
    }catch (e) {
        console.log(e)
    }
}


export const remove = async (id) => {
    try {
       await axios.post("http://localhost:8080/penalty/delete?id=" + id)

    }catch (e) {
        console.log(e)
    }
}