import React, { useEffect, useState } from "react";
import "./ProductCards.css";
import axios from "axios";

const ProductCards = () => {
  const [products, setProducts] = useState([]);

  const [formData, setFormData] = useState({
    name: "",
    brand: "",
    price: ""
  });

  const [editId, setEditId] = useState(null);

  useEffect(() => {
    getAllProducts();
  }, []);

  const getAllProducts = () => {
    axios.get("http://localhost:8080/products")
      .then(res => setProducts(res.data));
  };

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  // 🔹 ADD or SAVE
  const handleSubmit = (e) => {
    e.preventDefault();

    if (!formData.name || !formData.brand || !formData.price) return;

    if (editId === null) {
      // ADD
      axios.post("http://localhost:8080/products", formData)
        .then(() => {
          getAllProducts();
          resetForm();
        });
    } else {
      // SAVE (EDIT)
      axios.put(`http://localhost:8080/products/${editId}`, formData)
        .then(() => {
          getAllProducts();
          resetForm();
        });
    }
  };

  const handleEdit = (product) => {
    setEditId(product.id);
    setFormData({
      name: product.name,
      brand: product.brand,
      price: product.price
    });
  };

  const handleDelete = (id) => {
    if (window.confirm("Delete this product?")) {
      axios.delete(`http://localhost:8080/products/${id}`)
        .then(() => getAllProducts());
    }
  };

  const resetForm = () => {
    setFormData({ name: "", brand: "", price: "" });
    setEditId(null);
  };

  return (
    <>
      {/* FORM */}
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

        <button type="submit">
          {editId === null ? "Add Product" : "Save"}
        </button>

        {editId !== null && (
          <button type="button" onClick={resetForm}>
            Cancel
          </button>
        )}
      </form>

      {/* CARDS */}
      <div className="card-container">
        {products.map((product) => (
          <div className="card" key={product.id}>
            <h3>{product.name}</h3>
            <p><strong>Brand:</strong> {product.brand}</p>
            <p className="price">₹ {product.price}</p>

            <div>
              <button onClick={() => handleEdit(product)}>Edit</button>
              <button
                style={{ backgroundColor: "red", color: "white" }}
                onClick={() => handleDelete(product.id)}
              >
                Delete
              </button>
            </div>
          </div>
        ))}
      </div>
    </>
  );
};

export default ProductCards;
