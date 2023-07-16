import axios from "axios";


export const getContractList = async (page) => {
    try {
        return (await axios.get("http://localhost:8080/api/employee/redeem/chooseContract?page=" + page)).data
    }catch (e) {
        console.log(e)
    }
}