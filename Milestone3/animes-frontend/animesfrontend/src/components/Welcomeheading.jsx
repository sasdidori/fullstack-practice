import { useEffect, useState } from "react";
import { fetchGetRequest } from "../api/requests";
import { APP_URL_WELCOME } from "../data/constants";

const Welcomeheading = () => {

    const [message, setMessage] = useState(null)

    useEffect(() => {
        fetchGetRequest(APP_URL_WELCOME)
        .then(res => res.text())
        .then(text => setMessage(text))
        console.log(text);
    }, [])
    
    return <>
    {message && 
    <div>
        {message}
        </div>}
    </>

}

export default Welcomeheading;