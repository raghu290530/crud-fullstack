import React, { useEffect, useState } from "react";
import "./ProductCards.css";
import axios from 'axios'



const ProductCards = () => {
    const [products,setProducts] = useState([
        { id: 1, brand: "Dell", name: "Laptop Pro 15", price: 75000 },
      ])

      const [formData, setFormData] = useState({
        name: "",
        brand: "",
        price: ""
      });
    // const [delId,setDelId] = useStates();
    useEffect(()=>{
        getAllProducts();
    },[])

    const getAllProducts = () =>{
        axios.get("http://localhost:8080/products")
        .then(res=>{
            setProducts(res.data);
        }
        );
    }

    const handleDelete = (id) =>{
        if(window.confirm("Delete this product")){
            axios.delete(`http://localhost:8080/products/${id}`)
            .then(()=>getAllProducts());
    }
    }
    const handleChange = (e) => {
        setFormData({ ...formData, [e.target.name]: e.target.value });
    };
 
    const handleSubmit = (e) => {
        e.preventDefault();
    
        if (!formData.name || !formData.brand || !formData.price) return;
    
        axios.post("http://localhost:8080/products",formData)
        .then(()=>getAllProducts());
    
        // setFormData({ name: "", brand: "", price: "" });
      };
    
      const handleUpdate = ()=>{
        
      }
   


  return (
    <>
        <form className="product-form" onSubmit={handleSubmit}>
        <input
          type="text"
          name="name"
          placeholder="Product Name"
          value={formData.name}
          onChange={handleChange}
        />
        <input
          type="text"
          name="brand"
          placeholder="Brand"
          value={formData.brand}
          onChange={handleChange}
        />
        <input
          type="number"
          name="price"
          placeholder="Price"
          value={formData.price}
          onChange={handleChange}
        />
        <button type="submit">Add Product</button>
      </form>
      <p>{formData.price} + {formData.brand} + {formData.name}</p>
    <div className="card-container">
        <form action="handleSubmit"></form>
      {products.map((product) => (
        <div className="card" key={product.id}>
          <h3>{product.name}</h3>
          <p><strong>Brand:</strong> {product.brand}</p>
          <p className="price">₹ {product.price}</p>
          <div>
            <button onClick={handleUpdate}>Update</button> 
            <button 
            style={{backgroundColor:"red", color:"white"}}
            onClick={()=>handleDelete(product.id)}>Delete</button>
          </div>
        </div>
      ))}
    </div>
    </>
  );
};

export default ProductCards;
