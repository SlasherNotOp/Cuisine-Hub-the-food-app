import React from 'react'

const CarouselItem = ({image,title}) => {
  return (
    <div className='flex flex-col h-full justify-center w-full items-center'>

        <img src={image} alt={title} className='w-40 h-40 lg:w-56 lg:h-56 object-cover object-center ' />
        <span className='py-5 font-semibold text-xl text-gray-400'>{title}</span>
      
    </div>
  )
}

export default CarouselItem
