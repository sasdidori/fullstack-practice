import { useEffect, useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function App() {
  const [books, setBooks] = useState([]);
  const [title, setTitle] = useState("");
  const [rating, setRating] = useState("");


  console.log("fetched books", books);

  const getBooks = () => {
    return fetch("http://localhost:8080/books").then((res) => res.json())
  }

  const addBook = (book) => {
    return fetch("http://localhost:8080/books", {
      method: "POST",
      headers: {
        "Content-Type" : "application/json"
      },
      body: JSON.stringify(book)
    }).then((res) => res.json())
  }

  useEffect(() => {
    getBooks()
    .then((data) => {
      setBooks(data)
    })
  }, [])

 const handleSubmit = async(e) => {
  e.preventDefault();

  const newBook = {title: title, rating: rating}
  try {
    await addBook(newBook)

  } catch(error) {
    console.log("error adding new book");
  }
 }


  return (
    <>
      <div>
        <form onSubmit={handleSubmit}>
          <label>Title of the book:</label> <br />
          <input placeholder='booktitle here'
          value={title}
          onChange={(e) => setTitle(e.target.value)}
          ></input> <br />
          <label>How do you rate the book?</label> <br />
          <input placeholder='number between 0-10'
          value={rating}
          onChange={(e) => setRating(e.target.value)}
          ></input> <br />
          <button type='submit'> add book </button>
        </form>
        
      </div> <br />
      <div>My Booklist</div> <br />
      <div>
        {books && books.map((book) => (
          <div key={book.id}>
            <div>{book.title}</div>
            <div>{book.rating}</div> <br />
          </div>
        ))}
      </div>
    </>
  )
}

export default App
