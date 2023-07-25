import axios from "axios";


export const getListCustomerAPI = (page) => {
    return axios.get("http://localhost:8080/api/employee/liquidation/customers?page="+page);
};
export const searchCustomerAPI = (page, name) => {
    return axios.get("http://localhost:8080/api/employee/liquidation/customers/search?page=" + page + "&name=" + name);
};
export const searchContractAPI = (page, productName, productType, loans) => {
    return axios.get("http://localhost:8080/api/employee/liquidation/contracts/search?page=" + page + "&productName=" + productName + "&productType=" + productType + "&loans=" + loans);
};

export const getListProductTypeAPI = () => {
    return axios.get("http://localhost:8080/api/employee/type/contract/productType");
};
export const getListProductAPI = (page) => {
    return axios.get("http://localhost:8080/api/employee/liquidation/contracts?page="+page);
};
export const saveLiquidationAPI = (liquidation) => {
    return axios.post("http://localhost:8080/api/employee/liquidation", liquidation);
}