import { Divider, FormControl, FormControlLabel, Grid, Radio, RadioGroup, Typography } from '@mui/material'
import React, { useState } from 'react'
import LocationOnIcon from '@mui/icons-material/LocationOn';
import CalendarTodayIcon from '@mui/icons-material/CalendarToday';
import MenuCard from '../Component/Restaurant/MenuCard';

const RestaurantDetails = () => {

    const menu=[
        1,2,3,3,3,3,3
    ]

    const [foodType,setFoodType]=useState("all");

    const handleFilter=(e)=>{
        console.log(e.target.value,e.target.name);
        setFoodType(e.target.value)
    }

    const categories=[
        "pizza",
        "biryani",
        "burger",
        "chicken",
        "rice"
    ]

    const foodTypes=[
        {label:"all",value:"all"},
        {label:"Vegetarian only",value:"Vegetarian"},
        {label:"Non-Vegetarian",value:"non_vegetarian"},
        {label:"Seasonal",value:"seasonal"},

    ]

  return (
    <div className='px-5 lg:px-20'>
        <section>
            <h3 className='text-gray-500 py-2 mt-10'>Home/india/indian fast food/3</h3>
            <div>
                <Grid container spacing={2}>
                    <Grid item xs={12}>
                        <img 
                        className='w-full h-[40vh] object-cover'
                        src='https://assets.gqindia.com/photos/62a9d4653e8cdc9b632eb2ad/16:9/w_2560%2Cc_limit/10%2520restaurants%2520in%2520Mumbai%2520that%2520offer%2520the%2520best%2520sunset%2520views.jpg' alt=''/>

                    </Grid>

                    <Grid item xs={12} lg={6}>
                        <img 
                        className='w-full h-[40vh] object-cover'
                        src='https://b.zmtcdn.com/data/pictures/3/21019923/f46b0821552a661273727b58d2c6d7db_featured_v2.jpg' alt=''/>

                    </Grid>

                    <Grid item xs={12} lg={6}>
                        <img 
                        className='w-full h-[40vh] object-cover'
                        src='https://t3.ftcdn.net/jpg/03/24/73/92/360_F_324739203_keeq8udvv0P2h1MLYJ0GLSlTBagoXS48.jpg' alt=''/>

                    </Grid>


                </Grid>
                
            </div>

            <div className='pt-3 pb-5'>
                <h1 className='text-4xl font-semibold '>Indian Fast Food</h1>
                <p className='text-gray-500 flex items-center gap-3 '>Restaurant Description afkj ajf;s;fdkajfk jkafjkjfwjekjf jlkdjkvjknkmkk, maofuiwerjklan k,mvalkrojwer dknafklmlk f aljeraew; 
                </p>
                <p className='text-gray-500 flex items-center gap-3 '>
                    <span><LocationOnIcon/></span>
                    Mumbai, Maharastra 
                </p>
                <p className='text-gray-500 flex items-center gap-3 '>
                <span><CalendarTodayIcon/></span>
                opening time
                </p>

            </div>

        </section>
        <Divider/>

        <section className='p-8 lg:flex relative'>

            <div className="space-y-10 lg:w-1/5 filter  ">
                <div className='box space-y-5 lg:sticky top-28 '>
                    <div>
                        <Typography variant='h5' sx={{paddingBottom:"1rem"}}>
                            Food Type
                        </Typography>
                        <FormControl className='py-10 space-y-5 ' component={"fieldset"}>

                            <RadioGroup name='food_type' value={foodType}
                            onChange={handleFilter}
                            >

                                {
                                
                                foodTypes.map((item,ind)=>{
                                    return(
                                        
                                        <FormControlLabel 
                                        key={ind}
                                        value={item.value} control={<Radio />} label={item.label} />
                                        

                                    )
                                })
                            
                        }

                            

                            </RadioGroup>
                        </FormControl>
                    </div>

                    <Divider/>
                    <div>
                        <Typography variant='h5' sx={{paddingBottom:"1rem"}}>
                            Food Categories
                        </Typography>
                        <FormControl className='py-10 space-y-5 ' component={"fieldset"}>

                            <RadioGroup name='food_type' value={foodType}
                            onChange={handleFilter}
                            >

                                {
                                
                                categories.map((item,ind)=>{
                                    return(
                                        
                                        <FormControlLabel 
                                        key={ind}
                                        value={item} control={<Radio />} label={item} />
                                        

                                    )
                                })
                            
                        }

                            

                            </RadioGroup>
                        </FormControl>
                    </div>

                </div>

            </div>


            <div className="space-y-5 lg:w-4/5 lg:pl-10 ">
                {
                   menu.map(item=><MenuCard/>)
                }

            </div>

        </section>



        
      
    </div>
  )
}

export default RestaurantDetails
