import {Outlet, Link} from "react-router-dom";
import "./SignUp.css"

const SignUp = () => {

    return (
        <>
        <div className="title">SIGN UP</div>
        <div className="form-center">
        <form className="form" >
            <input className="inputfield" placeholder="info@mailaddress.com"
            ></input> <br />
            <input className="inputfield" placeholder="**************"
            ></input> <br />
            <div className="form_field">
                <input type="submit" value={"Sign Up"}></input>
            </div>
            <p>Already have an account?<Link to={"/login"} className="login">LOGIN</Link></p>
        </form>
        <Link to={"/"}>Back</Link>
        </div>
        </>
    )
}

export default SignUp;