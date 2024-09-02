import React from 'react'
import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";
import TopMeal from './TopMeal';
import Slider from 'react-slick/lib/slider';
import CarouselItem from '../Component/CarouselItem';


const MultiItem = () => {

  const settings = {
    dots: true,
    infinite: true,
    speed: 500,
    slidesToShow: 4,
    slidesToScroll: 2,

    autoplay: true,
    
    autoplaySpeed:2000, 

    arrows:false,


  };

  


  

  return (
    <div className=' slider-parent '>
      <Slider {...settings} >
        {
          TopMeal.map((item)=>{
            return(
            <CarouselItem image={item.image} title={item.title}/>
            )
          })
        }

      </Slider>
      
    </div>
  )
}

export default MultiItem
