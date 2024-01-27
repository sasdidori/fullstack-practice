
import { useState, useEffect } from 'react'
import './App.css'

function App() {
  const [animeList, setAnimeList] = useState([])
  const [newAnime, setNewAnime] = useState("")
  const [rating, setRating] = useState("")
 
  console.log("new anime name:", newAnime);
  
 
  
  const fetchAnimes = () => {
    return fetch('http://localhost:8080/animes')
        .then((res) => res.json())
        .catch(error => {
            console.error("Error fetching anime data:", error);
            return [];
        });
};


  useEffect(() => {
    fetchAnimes()
    .then((data) => {
            console.log("fetched animes:", data);
            setAnimeList(data)
    })
  }, []);

  const addAnime = (anime) => {
    return fetch('http://localhost:8080/animes', {
      method: "POST",
      headers: {
        "Content-Type" : "application/json"
      },
      body:JSON.stringify(anime)
    }).then((res) => res.json())
  } 



  const handleSubmit = async(e) => {
    e.preventDefault();

    const addedAnime = {title: newAnime, rating: rating}
    try{
      await addAnime(addedAnime)
    } catch (error) {
      console.log("error");
    }
    
    console.log("added anime:", addedAnime);
  }
 
  return (
    <>
    <div>Animelist</div>
    <div>
      {animeList && animeList.map((a) => (
        <div key={a.id}>
          <div>{a.title}</div>
          <div>{a.rating}</div>
          </div>
      ))}
    </div>
    <div>
    <form onSubmit={handleSubmit}>
    <label>Add an anime</label> <br />
    
    <input placeholder='add title'
    value={newAnime}
    onChange={(e) => setNewAnime(e.target.value)}></input> <br />
    <input placeholder='add rating'
    value={rating}
    onChange={(e) => setRating(e.target.value)}></input> <br />
     <button type='submit'>add anime</button>
    </form>
    </div>
    </>
  )
}

export default App
