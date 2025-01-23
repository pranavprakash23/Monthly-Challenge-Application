import { useState } from 'react'
import './App.css'
import Home from './pages/Home'

function App() {
  const [count, setCount] = useState(0)

  return (
    <div className='w-[1200px] h-screen py-4'>
     <Home/>
    </div>
  )
}

export default App
