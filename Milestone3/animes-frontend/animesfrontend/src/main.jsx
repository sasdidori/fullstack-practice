import React from 'react'
import ReactDOM from 'react-dom/client'
import {
  createBrowserRouter,
  RouterProvider,} from "react-router-dom";
import Layout from './components/Layout';
import Login from './components/Login';
import AnimeList from './components/AnimeList';
import AnimeCreator from './components/AnimeCreator';
import SignUp from './components/SignUp';


const router = createBrowserRouter([
  {
    path: "/",
    element: <Layout/>,
    children: [
      {
        path: "/",
        element:<AnimeList/>
       },
      {
        path: "/create",
        element:<AnimeCreator/>
      },
    ]
  },
  {
    path: "/login",
    element:<Login/>
  },
  {
    path: "/signup",
    element:<SignUp/>
  }
])

ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);
