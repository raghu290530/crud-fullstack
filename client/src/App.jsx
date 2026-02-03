import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import ProductCards from './component/ProductCards'
import { Login } from './component/Login'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      {/* <ProductCards/> */}
      <Login/>
    </>
  )
}

export default App
