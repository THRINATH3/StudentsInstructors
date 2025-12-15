import React from 'react'
import Header from './components/header/Header'
import Footer from './components/footer/Footer'
import { Outlet } from 'react-router-dom'
function RootLayout() {
  return (
    <div className='bg-black'>
        <Header  />
        <div style={{minHeight:'100vh',minWidth:'100%'}}>
            <Outlet />
        </div>
        <Footer />
    </div>
  )
}

export default RootLayout