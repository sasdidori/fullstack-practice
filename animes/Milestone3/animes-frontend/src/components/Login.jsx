import { useRef, useState } from "react";
import {Link, useNavigate} from "react-router-dom";
import { login } from "../security/login";
import Welcomeheading from "./Welcomeheading";


const Login = () => {

    const usernameRef = useRef()
    const passwordRef = useRef()
    const navigate = useNavigate()
    const [showError, setShowError] = useState(false)


    const handleSubmit = async(e) => {
        e.preventDefault()

        const userName = usernameRef.current.value
        const password = passwordRef.current.value

        console.log("username: " + `${userName}`, 'password: ' + `${password}`);

        const isLoginSuccessful = await login(userName, password)
        if(isLoginSuccessful) {
            navigate("/")
        } else {
            setShowError(true)
        }
    }

    return (
        <>
        <div className="title">LOGIN</div>
        <Welcomeheading/>
        <div className="form-center">
        <form className="form"  onSubmit={handleSubmit}>
            <input className="inputfield" placeholder="info@mailaddress.com" type='text' ref={usernameRef}
            ></input> <br />
            <input className="inputfield" placeholder="**************" type='text' ref={passwordRef}
            ></input> <br />
            <div className="form_field">
                <input type="submit" value={"Login"}></input>
            </div>
            <p>Already registered?<Link to={"/signup"} className="login">SIGNUP</Link></p>
            {showError && (
                <div>
                    Login credentials are incorrect. Try again.
                </div>
            )}
        </form>
        </div>
        </>

    )
}

export default Login;

