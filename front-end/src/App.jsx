import React from 'react'
import { createBrowserRouter, RouterProvider } from 'react-router-dom'
import RootLayout from './RootLayout'
import Home from './components/home/Home'
function App() {

  const browserRouter = createBrowserRouter([
    {
      path:'',
      element: <RootLayout></RootLayout>,
      children:[
        {
          path:'',
          element: <Home></Home>
        }
      ]
    }
  ])

  return (
    <div>
      <RouterProvider router={browserRouter}></RouterProvider>
    </div>
  )
}

export default App