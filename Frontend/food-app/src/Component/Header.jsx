import { IconButton } from '@mui/material'
import React from 'react'

const Header = () => {

  return (

    <div className='flex text-white justify-between bg-[#e91e63] py-4 px-5 z-50 lg:px-20 '>
      
    
      <div className='lg:mr-10 flex items-center space-x-4'>
        <li className='cursor-pointer logo font-semibold text-gray-300 text-2xl '>Cuision Hub</li>
      </div>

    

      <div className='flex items-center space-x-2 lg:space-x-10'>
        
        <div className=''>

        <IconButton></IconButton>


        </div>

      </div>

    </div>
  )
}

export default Header
