import axios from "axios";

export const getTeamList = async () => {
    try {
        const res = await  axios.get("http://localhost:8080/player/team-list")
        return res.data
    }catch (e) {
        console.log(e)
    }
}

export const save = async (value) => {
    try {
      await  axios.post("http://localhost:8080/player/create", value)

    }catch (e) {
        console.log(e)
    }
}

export const top5 = async () => {
    try {
        const res = await  axios.get("http://localhost:8080/penalty/top5")
        return res.data
    }catch (e) {
        console.log(e)
    }
}