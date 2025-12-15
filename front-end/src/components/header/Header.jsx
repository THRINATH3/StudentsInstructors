import React from 'react'
import Logo from '../../assets/Logo.png';
import { FcSearch } from "react-icons/fc";
import { Link } from 'react-router-dom';
function Header() {
  return (
    <div className='bg-black p-3 pt-4' style={{display:'flex',columnGap:'250px',alignItems:'center',position:'fixed'}}>
       <div>
          <img src={Logo} alt="" width={200} />
       </div>
       <div style={{alignItems:'center'}}>
          <input type="text" style={{width:'400px',borderRadius:'50px',padding:'8px',paddingLeft:'15px'}} placeholder='Search '  />
          <FcSearch className='fs-3 bg-white' style={{borderRadius:'50px',marginLeft:'-50px'}}/>
       </div>
       <div style={{display:'flex',columnGap:'60px'}}>
          <Link to='' className="fs-5 text-decoration-none text-white" >About</Link>
          <Link to='' className="fs-5 text-decoration-none text-white" >Login/Signup</Link>
          <Link to='' className="fs-5 text-decoration-none text-white" >Help</Link>
       </div>
    </div>
  )
}

export default Header