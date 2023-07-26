import React from "react";
import {Link} from "react-router-dom";

export const CreateButton = (props) => {

    return (
        <>
            <Link to='/create-order'  className='btn btn-success'>
                Them moi don hang
            </Link>
        </>
    )
}