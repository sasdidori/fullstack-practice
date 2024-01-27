import {Outlet, Link, useNavigate} from "react-router-dom";
import "./Layout.css"
import { getCredentials } from "../security/credentials";
import AnimeList from "./AnimeList";  
import { useEffect } from "react";


const Layout = () => {
    const navigate = useNavigate()
    const credentials = getCredentials()
    console.log(credentials);
   
    useEffect(() => {
        if(credentials == null) {
            navigate("/login")
        }
    }, [])

return (
    credentials == null ? 
    (<p> Not logged in. Redirecting to the login page...</p>)
    : (
    <div className="layout">
        <nav>
            <ul>
                <Link to={"/"} className="site-title">MY ANIMELIST</Link>
                <Link to={"/create"} className="add">ADD NEW ANIME</Link>
            </ul>
        </nav>
        <Outlet/>
    </div>
        ) 
    )
}

export default Layout;