import { Card, Chip, IconButton } from '@mui/material'
import React from 'react'
import FavoriteBorderIcon from '@mui/icons-material/FavoriteBorder';
import FavoriteIcon from '@mui/icons-material/Favorite';



const RestaurantCart = () => {
  return (
    <Card className=' w-72 '>
        <div className={ `${true?"cursor-pointer":"cursor-not-allowed"} relative`}>
            <img 
            className='w-full h-40 rounded-t-md object-cover' 
            src="https://assets.gqindia.com/photos/62a9d4653e8cdc9b632eb2ad/16:9/w_2560%2Cc_limit/10%2520restaurants%2520in%2520Mumbai%2520that%2520offer%2520the%2520best%2520sunset%2520views.jpg" alt='dfasf'/>
            <Chip
            size='small'
            className='absolute top-2 left-2'
            color={true?"success":"error"}
            label={true?"open":"closed"}

            />

        </div>
        <div className='p-4 textPart lg:flex w-full justify-between'>
          <div className='space-y-1'>
            <p className='font-semibold text-lg'>Indian Fast food</p>
            <p className='to-gray-500 text-sm '
            >Craving it all? Dive into our global fla...</p>

          </div>

          <div>
            <IconButton>
              {true?<FavoriteIcon/>:<FavoriteBorderIcon/>}
            </IconButton>
          </div>

        </div>

    </Card>
  )
}

export default RestaurantCart
