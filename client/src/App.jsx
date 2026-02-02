import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import ProductCards from './component/ProductCards'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <ProductCards/>
    </>
  )
}

export default App
