import React, {useEffect, useState} from "react";
import * as service from './service/PlayerService'

export const Top5 = () => {

    const [top, setTop] = useState([])

    const fetchApi = async () => {
      try {
          const res = await service.top5()
          await setTop(res)
      }catch (e) {
          console.log(e)
      }
    }
    useEffect(()=>{
        fetchApi()
    },[])

    return(
        <>
            <div

            >
                <div style={{marginBottom: 20}}>
                    <h1
                        className="d-flex justify-content-center"
                        style={{padding: 16}}
                    >
                        Danh sách top 5 cau thu ghi nhieu ban nhat
                    </h1>
                </div>

            </div>
            <table className="table table-striped ">
                <thead>
                <tr style={{textAlign: "start"}}>
                    <th>ID</th>
                    <th>Ten cau thu</th>
                    <th>Ten doi</th>

                    <th>So lan ghi ban</th>
                </tr>
                </thead>
                {top?.length === 0  ? (
                    <td colSpan="10">
                        <h4 className={"text-danger text-center my-3"}>
                            Dữ liệu không tồn tại
                        </h4>
                    </td>
                ) : (
                    <tbody>
                    {top.map((list, index) => (
                        <tr key={index}>
                            <td>{list.id}</td>
                            <td>{list.name}</td>
                            <td>{list.teamModel}</td>

                            <td>{list.scoreTimes}</td>
                        </tr>
                    ))}
                    </tbody>
                )}
            </table>
            </>
    )
}