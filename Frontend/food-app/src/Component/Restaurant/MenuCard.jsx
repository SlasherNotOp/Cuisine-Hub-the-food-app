import { Accordion, AccordionDetails, AccordionSummary, Button, Checkbox, FormControlLabel, FormGroup } from '@mui/material'
import React from 'react'
import ExpandMoreIcon from '@mui/icons-material/ExpandMore';

const ingredients=[
  {
    category:"Nuts & seeds",
    ingredient:["cashews"]
  },
  {
    category:"Protein",
    ingredient:["Ground beef","Bacon strips"]
  },
  {
    category:"Bread",
    ingredient:["Hamburger buns"]
  },
  {
    category:"Vegetable",
    ingredient:["Lettuce","Tomato slices","Pickles","Onion Slices"]
  },
  {
    category:"Condiment",
    ingredient:["Ketchup"]
  },
];

const MenuCard = () => {

  const handleCheckBoxChange=(value)=>{
    console.log(value)

  }

  const imagesburger="https://cdn.pixabay.com/photo/2021/07/19/16/04/pizza-6478478_1280.jpg";

  return (
    <Accordion>
        <AccordionSummary
          expandIcon={<ExpandMoreIcon />}
          aria-controls="panel1-content"
          id="panel1-header"
        >
         <div className='lg:flex items-center justify-between gap-4'>
          <div className='lg:flex items-center lg:gap-5 '>
            <img src={imagesburger} alt='this is image'
            className='w-28 h-28 object-cover '
            />
          </div>
          <div className='space-y-1 lg:space-y-5 lg:max-w-2xl'>
            <p className='font-semibold text-xl'> Burger</p>
            <p className='font-semibold text-xl'> ₹366</p>
            <p className='text-gray-400'>nice food</p>


          </div>
          
         </div>
        </AccordionSummary>
        <AccordionDetails>
          <form>
            <div className='flex gap-5 flex-wrap'>

            
           
           
            {
              ingredients.map((item)=>{



                return(
                  <div>
                    <p>{item.category}</p>

            <FormGroup>
              {
                item.ingredient.map((data)=>{
                  return(
                    <FormControlLabel control={<Checkbox 

                    onChange={()=>handleCheckBoxChange(data)}
                    
                    />} label={data} />


                  );

                })
              }
                            
                </FormGroup>
            </div>
                )


              })
              
            }




            </div>
            <div className='pt-5'>

            <Button 
            type="submit" variant='contained' disabled ={false}
            >{true?"Add to Cart":"Out of Stock"}</Button>
            </div>

          </form>
        </AccordionDetails>
      </Accordion>
  )
}

export default MenuCard
