import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Header from './Component/Header'
import { CssBaseline, ThemeProvider } from '@mui/material'
import { darkTheme } from './Theme/DarkTheme'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
    <ThemeProvider theme={darkTheme}>
    <CssBaseline/>

      
      <Header/>

      
      
      </ThemeProvider>
    </>
  )
}

export default App
