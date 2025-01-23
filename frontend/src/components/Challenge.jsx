import React from 'react'

const Challenge = ({data}) => {
  return (
    <div className='border-2 border-gray-300 rounded-md px-4 py-2 flex flex-col gap-2' >
        <h1 className='font-bold'>{data.month}</h1>
        <p>{data.description}</p>
    </div>
  )
}

export default Challenge;