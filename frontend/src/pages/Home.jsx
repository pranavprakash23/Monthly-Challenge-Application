import React, { useEffect, useState } from 'react'
import Challenge from '../components/Challenge'
import axios from 'axios';

const Home = () => {

    const [challenges , setChallenges] = useState([]);

    const [month, setMonth] = useState('');
    const [description, setDescription] = useState('')

    useEffect(()=>{
        try {
            fetchChallenges();
        } catch (error) {
            console.error("Error fetching challenge", error);
        }
        
    },[])

    const fetchChallenges = async()=>{
        const response =  await axios.get('http://localhost:8080/challenges');
        setChallenges(response?.data)
    };


    const handleSubmit = async(e) => {
        e.preventDefault();
        try {
            await axios.post('http://localhost:8080/challenges', {
                month: month,
                description: description
              });
            setMonth('');
            setDescription('');
            fetchChallenges();
        } catch (error) {
            console.error("Error adding challenge", error);
        }
    }


  return (
    <div>
        
        <div className='text-center font-bold text-3xl font-serif'>Monthly Challenges Application</div>

        <div className='border-2 border-gray-300 rounded-md mt-6'>
            <div className='bg-gray-200 text-xl font-bold pl-4 py-2'>Add New Challenge</div>
            <form onSubmit={handleSubmit}>
                <div className='flex flex-col gap-2 mx-4 my-4'>
                    <p className='text-lg font-semibold'>Month</p>
                    <textarea name="month" id="month" cols="30" rows="1" className='border-2 border-gray-200 rounded-md p-2' placeholder='e.g., January' value={month} onChange={(e)=>setMonth(e.target.value)}></textarea>

                    <p className='text-lg font-semibold mt-6'>Description</p>
                    <textarea name="month" id="month" cols="30" rows="4" className='border-2 border-gray-200 rounded-md p-2' placeholder='Describe the challenge' value={description} onChange={(e)=>setDescription(e.target.value)}></textarea>

                    <button type="submit" className='bg-blue-600 rounded-md mt-6 w-fit font-extrabold'>Submit</button>
                </div>

            </form>
        </div>
        <div className='w-full flex flex-col gap-2 mt-20'>
            {challenges.map((challenge)=>{
                return  <Challenge key={challenge.id} data={challenge}/>
            })}
        </div>
       
    </div>
  )
}

export default Home