import React from 'react'
import ReactDOM from 'react-dom/client'
import {
  createBrowserRouter,
  RouterProvider,
} from "react-router-dom";
import './index.css'
import Layout from './Components/Layout.jsx'
import AnimeCreator from './Components/AnimeCreator.jsx'
import AnimeList from './Components/AnimeList.jsx';



const router = createBrowserRouter([
  {
    path: "/",
    element: <Layout/>,
    children: [
      {  
        path: "/",
        element: <AnimeList/>
      },
    ]
  },
  {  
    path: "/create",
    element: <AnimeCreator/>,
  }
])

ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);
