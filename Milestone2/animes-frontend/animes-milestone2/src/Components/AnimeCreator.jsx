import { useState } from "react";
import { Link } from "react-router-dom";
import "./AnimeCreator.css";

const createAnime = (anime) => {
    return fetch('http://localhost:8080/animes', {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(anime),
    }).then((res) => res.json());
}


const AnimeCreator = () => {
    const [animeTitle, setAnimeTitle] = useState("")
    const [animeRating, setAnimeRating] = useState("")

    const handleSubmit = async(e) => {
        e.preventDefault();

        const addedAnime = {title: animeTitle, rating: animeRating}

        try{
            await createAnime(addedAnime)
            setAnimeTitle("")
            setAnimeRating("")
        } catch (error) {
            console.log("error creating the anime");
        }
        console.log("added anime", addedAnime);
    }

    return (<>
        <div className="title">Add an anime</div>
        <div className="form-center">
        <form className="form" onSubmit={handleSubmit}>
            <label className="label" >Title</label> <br />
            <input className="inputfield" placeholder="title..."
            value={animeTitle}
            onChange={(e) => setAnimeTitle(e.target.value)}
            ></input> <br />
            <label className="label">Rating</label> <br />
            <input className="inputfield" placeholder="rating..."
            value={animeRating}
            onChange={(e) => setAnimeRating(e.target.value)}
            ></input> <br />
            <button className="button">Add anime</button>
        </form>
        </div>

        <Link to={"/"}>Back</Link>
        </>
    )
}

export default AnimeCreator;