import axios from "axios";


export const getOrderList = async (page) => {
    try {
        const res = await axios.get("http://localhost:8080/api/admin/")
        return res.data
    }catch (e) {
        console.log(e)
    }
}