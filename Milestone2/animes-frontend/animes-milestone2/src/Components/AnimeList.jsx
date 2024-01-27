import { useEffect, useState } from "react"
import "./AnimeList.css"

const fetchAnimes = () => {
    return fetch('http://localhost:8080/animes').then((res) => res.json())
}


const deleteAnimes = (id) => {
    return fetch(`http://localhost:8080/animes/${id}`, 
    {
        method: "DELETE"})
    };



const AnimeList = () => {

    const [animes, setAnimes] = useState([])
    const [loading, setLoading] = useState(false)

    useEffect(() => {
        fetchAnimes()
        .then((data) => {
            setAnimes(data)
            console.log(data);
        })
    }, [])

    const handleDelete = async (id) => {
     setLoading(true)
     const response= await deleteAnimes(id);
     if(response.status == 200) {
        const updated = animes.filter(anime => anime.id != id)
        setAnimes(updated)
     }
     setLoading(false)
    }

    return (
        <>
        <div className="title">Watched animes</div>
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
            onClick={()=> handleDelete(anime.id)}
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