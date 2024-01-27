import { useEffect, useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function App() {

  const [todos, setTodos] = useState([])
  const [text, setText] = useState("")
  const [isCompleted, setIsCompleted] = useState(false)

  console.log("new todo", text);
  console.log("is complete?", isCompleted);

  const fetchTodos = () => {
    return fetch ('http://localhost:8080/todos')
    .then((res) => res.json())
  }
  
  useEffect(() => {
    fetchTodos()
    .then((data) =>{
    setTodos(data)
  }) 
  }, []);

  const addTodo = (todo) => {
    return fetch('http://localhost:8080/todos', {
      method: "POST",
      headers: {
        "Content-Type" : "application/json"
      },
      body:JSON.stringify(todo)
    }).then((res) => res.json())
  }

  const handleSubmit = async(e) => {
    e.preventDefault();

    const newTodo = {text: text, isCompleted: isCompleted}
    try{
      await addTodo(newTodo)
    } catch(error){
      console.log("error adding todo");
    }
  }

  return (
    <>
      <div>Todolist</div> <br />
      <div>
        {todos && todos.map((todo) => (
          <div key={todo.id}>
            <div>{todo.text}</div> 
            <div>{todo.isCompleted.toString()}</div> <br />
            </div>
        ) )}
        </div> <br />
        <div>
          <form onSubmit={handleSubmit}>
            <label>Add a todo</label> <br />
            <input placeholder='add text'
            value={text}
            onChange={(e) => setText(e.target.value)}
            ></input> <br />
            <input placeholder='is complete?'
            value={isCompleted}
            onChange={(e) => setIsCompleted(e.target.value)}
            ></input> <br />
            <button type='submit'> add todo</button>
          </form>
        </div>
     
     
      
    </>
  )
}

export default App
