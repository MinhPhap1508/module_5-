import axios from "axios"
import { toast } from "react-toastify";

export const getAll = async () => {
    try{
        const res = await axios.get('http://localhost:8080/facility')
        return res.data
    }catch(e){
        console.log(e);
    }
}
export const getById = async (id) => {
    try{
        const res = await axios.get("http://localhost:8080/facility/"+id)
        return res.data
    }catch(e){
        console.log(e);
    }
}
export const createFacility = async (facility) => {
    try{
        await axios.post('http://localhost:8080/facility', facility)
    }catch(e){
        console.log(e);
    }
}
export const editFacility = async (facility) => {
    try{
        await axios.put('http://localhost:8080/facility/'+facility.id, facility)
    }catch(e){
        console.log(e);
        toast("Edit thất bại")
    }
} 
export const deleteFacility = async (id) => {
    try{
        await axios.delete('http://localhost:8080/facility/'+id)
    }catch(e){
        console.log(e);
    }
}