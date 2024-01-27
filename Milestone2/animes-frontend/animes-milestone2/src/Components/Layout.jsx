import {Outlet, Link} from "react-router-dom";
import "./styles.css"

const Layout = () => {
    return(
        <div className="layout">
             <nav>
                <ul>
                      <div className="site-title">MY ANIMELIST</div>  
                       <Link to={"/create"} className="add">
                            ADD NEW ANIME
                        </Link>
                </ul>
              
             </nav>
             <Outlet/>
        </div>

       
        
    )
};

export default Layout;