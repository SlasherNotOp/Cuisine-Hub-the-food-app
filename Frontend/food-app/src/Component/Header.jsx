import { Avatar, Badge, IconButton } from '@mui/material'
import React from 'react'
import SearchIcon from '@mui/icons-material/Search';
import { pink } from '@mui/material/colors';
import ShoppingCartIcon from '@mui/icons-material/ShoppingCart';

const Header = () => {

  return (

    <div className='flex text-white justify-between bg-[#e91e63] py-4 px-5 z-50 lg:px-20 '>
      
    
      <div className='lg:mr-10 flex items-center space-x-4'>
        <li className='cursor-pointer logo font-semibold text-gray-300 text-2xl list-none '>Cuision Hub</li>
      </div>

    

      <div className='flex items-center space-x-2 lg:space-x-10'>
        
        <div className=''>

        <IconButton >
          <SearchIcon sx={{fontSize:"1.5rem"}}/>
        </IconButton>
        </div>
        <div className=''>
        
        <Avatar sx={{bgcolor:"white", color:pink[400]}}>S</Avatar>
        
        </div>

        <div className=''>
        
        <IconButton >
          <Badge color='secondary' badgeContent={3}>
            <ShoppingCartIcon sx={{fontSize:"1.5rem"}}/>
          </Badge>
        </IconButton>
        
        </div>

      </div>

    </div>
  )
}

export default Header
