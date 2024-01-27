
import { useState, useEffect } from "react";
import "./AnimeList.css"
import { APP_URL_ANIMES } from "../data/constants";
import { getCredentials } from "../security/credentials";
import { fetchGetRequest } from "../api/requests";

function getAnimes() {
    const credentials = getCredentials()
    return fetchGetRequest(APP_URL_ANIMES, credentials)
        .then((response)=> response.json())
}


const deleteAnime = (id) => {
    return fetch(`http://localhost:8080/animes/${id}`, 
    {
        method: "DELETE"})
    };


const AnimeList = () => {

    const [animes, setAnimes] = useState([])
    const [loading, setLoading] = useState(false)

    useEffect(() => {
        getAnimes()
        .then((data) => {
            setAnimes(data)
            console.log(data);
        })
    }, [])

    const handleDelete = async(id) => {
        setLoading(true)
        const response = await deleteAnime(id)

        if(response.status == 200) {
            const updatedstate = animes.filter(anime => anime.id != id)
            setAnimes(updatedstate)
        }
        setLoading(false)
    }
    

    return (
        <>
         <div className="title">WATCHED ANIMES</div>
        <div className="animelist">

            <table>
                <thead>
                    <tr>
                        <th className="animetitle">TITLE</th>
                        <th className="animerating">RATING</th>
                        <th>DELETE</th>
                    </tr>
                </thead>
                <tbody className="tbody">
                {animes && animes.map((anime) => (
            <tr key={anime.id}>
            <td>{anime.title}</td>
            <td>{anime.rating}</td>
            <td>
            <button className="deletebutton" disabled={loading}
            onClick={() => handleDelete(anime.id)}
            >Delete
            </button>
            </td>
            </tr>
                ))}
                </tbody>
            </table>
        </div>
        </>
    )
}

export default AnimeList;