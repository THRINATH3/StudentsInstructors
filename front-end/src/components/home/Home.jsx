import React, { useState } from 'react'
import Home1 from '../../assets/Home1.png'
import Home2 from '../../assets/Home2.png'
import Home3 from '../../assets/Home3.png'
import Home4 from '../../assets/Home4.png'
import Home5 from '../../assets/Home5.png'
import coursesData from '../../assets/Courses'
import { GiTeacher } from "react-icons/gi";
import './Home.css';
function Home() {
  const photos = [Home1, Home2, Home3,Home4,Home5];
  console.log(coursesData);
  let [idx,setIdx] = useState(0);
  let underline = 4;

  function changeIndex(x){
    setIdx(x);
  }

  return (
    <div className="container" style={{paddingTop:'100px'}}>
      
      <div id="homeCarousel" className="carousel slide" data-bs-ride="carousel">
        
        <div className="carousel-inner ">
          {photos.map((img, index) => (
            <div
              key={index}
              className={`carousel-item ${index === 0 ? 'active' : ''}`}
            >
              <img
                src={img}
                alt={`slide-${index}`}
                style={{width:'100%',height:'500px',borderRadius:'50px'}}
              />
            </div>
          ))}
        </div>

        {/* Next button */}
        <button
          className="carousel-control-next"
          type="button"
          data-bs-target="#homeCarousel"
          data-bs-slide="next"
        >
          <span className="carousel-control-next-icon"></span>
        </button>

      </div>

      {/* Contents in site :  */}
      <div className="container text-white mt-5">
        <h1 style={{fontWeight:'bold'}} className='mb-3'>Skills to transform your career</h1>
        <div className='mb-3' style={{display:'flex',alignItems:'center',columnGap:'80px'}}>
          <h5 style={{cursor:'pointer',borderBottom:idx == 0 ? 'solid white 1px' : '',marginBottom:'-4px'}} onClick={()=>(changeIndex(0))} >Artifical Intelligence</h5>
          <h5 style={{cursor:'pointer',borderBottom:idx == 1 ? 'solid white 1px' : '',marginBottom:'-4px'}} onClick={()=>(changeIndex(1))} >Full Stack</h5>
          <h5 style={{cursor:'pointer',borderBottom:idx == 2 ? 'solid white 1px' : '',marginBottom:'-4px'}} onClick={()=>(changeIndex(2))} >Java</h5>
          <h5 style={{cursor:'pointer',borderBottom:idx == 3 ? 'solid white 1px' : '',marginBottom:'-4px'}} onClick={()=>(changeIndex(3))} >Microsoft-Excel</h5>
          <h5 style={{cursor:'pointer',borderBottom:idx == 4 ? 'solid white 1px' : '',marginBottom:'-4px'}} onClick={()=>(changeIndex(4))} >Python</h5>
          <h5 style={{cursor:'pointer',borderBottom:idx == 5 ? 'solid white 1px' : '',marginBottom:'-4px'}} onClick={()=>(changeIndex(5))} >C/CPP</h5>
        </div>
        <br />
        <div className='no-scrollbar' style={{display:'flex',columnGap:'30px',overflowX:'auto'}}>
          {coursesData[idx].map((data)=>(
          <div className='container p-3' style={{border:'solid white 1px',borderRadius:'20px'}}>
            <div className="text-center">
              <img  src={data.image} alt="" style={{width:'300px',height:'150px',marginBottom:'10px',borderRadius:'20px'}} />
            </div>
            <h5>{data.title}</h5>
            <p><GiTeacher className='fs-2 mb-1' /> {data.author}</p>
            <div style={{display:'flex',columnGap:'20px'}}>
              <span className="badge bg-secondary fs-6">Bestseller</span>
              <span className="badge bg-info fs-6">{data.price}</span>
              <span className="badge bg-light text-dark fs-6">⭐ {data.rating}</span>
            </div>
          </div>
        ))}
        </div>
      </div>
      
    </div>
  )
}

export default Home
