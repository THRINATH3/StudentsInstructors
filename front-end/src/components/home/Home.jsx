import React from 'react'
import Home1 from '../../assets/Home1.png'
import Home2 from '../../assets/Home2.png'
import Home3 from '../../assets/Home3.png'
import Home4 from '../../assets/Home4.png'
import Home5 from '../../assets/Home5.png'

function Home() {
  const photos = [Home1, Home2, Home3,Home4,Home5];

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
                className="d-block"
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

    </div>
  )
}

export default Home
