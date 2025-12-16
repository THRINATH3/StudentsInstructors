import React from 'react'
import Logo from '../../assets/Logo.png';
import { FcSearch } from "react-icons/fc";
import { Link } from 'react-router-dom';
import './Header.css'
function Header() {
  return (
    <div className='bg-black p-3 pt-4' style={{display:'flex',columnGap:'250px',alignItems:'center',position:'fixed',zIndex:'1000'}}>
       <div>
          <img src={Logo} alt="" width={200} />
       </div>
       <div style={{alignItems:'center'}}>
          <input type="text" style={{width:'400px',borderRadius:'50px',padding:'8px',paddingLeft:'15px'}} placeholder='Search '  />
          <FcSearch className='fs-3 bg-white' style={{borderRadius:'50px',marginLeft:'-50px'}}/>
       </div>
       <div  style={{display:'flex',columnGap:'50px'}}>
          <Link to='' className="text-decoration-none link" >About</Link>
          <Link to='' className="text-decoration-none link" >Login/Signup</Link>
          <Link to='' className="text-decoration-none link" >Explore</Link>
       </div>
    </div>
  )
}

export default Header