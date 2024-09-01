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
    slidesToShow: 3,
    slidesToScroll: 3
  };

  


  

  return (
    <div className='w-full'>
      <Slider {...settings} >
        {
          TopMeal.map((item)=>{
            <CarouselItem image={item.image} title={item.title}/>
          })
        }

      </Slider>
      
    </div>
  )
}

export default MultiItem
