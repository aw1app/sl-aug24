import React, { useEffect, useState } from 'react';
import { BrowserRouter as Router, Route, Routes, Link, useParams } from 'react-router-dom';
import './Navbar.css'; // Import the CSS file

import { Formik, Form, Field, ErrorMessage } from 'formik';
import * as Yup from 'yup';

const AppDemoRouter = () => {
  const [products, setProducts] = useState([]);

  // Fetch products from the API
  useEffect(() => {
    fetch('http://localhost:5000/products')
      .then((response) => response.json())
      .then((data) => setProducts(data))
      .catch((error) => console.error('Error fetching products:', error));
  }, []);

  return (
    <Router>
      <div>
        {/* Navbar Component */}
        <Navbar />
        <h1 style={{textAlign:'center'}}>Amzn Product Management</h1>

        {/* Routes for different views */}
        <Routes>
          <Route path="/" element={null} />
          <Route path="/list-products" element={<ProductList products={products} />} />
          <Route path="/product/:id" element={<ProductContainer products={products} />} />
          <Route path="/create-product" element={<ProductForm />} />
        </Routes>
      </div>
    </Router>
  );
};


//Navbar.js
const Navbar = () => {
  return (
    <nav className="navbar">
      <ul className="navbar-links">
      <li>
          <Link to="/">Home</Link>
        </li>
        <li>
          <Link to="/list-products">List Products</Link>
        </li>
        <li>
          <Link to="/create-product">Create Product</Link>
        </li>
      </ul>
    </nav>
  );
};


//Product Details Component
// ProductDetails.js
const Product = ({ product }) => {
  if (!product) return <div>Loading...</div>;

  return (
    <div>
      <h2>{product.name}</h2>
      <p>Price: ${product.price}</p>
      <p>Description: {product.description}</p>
      <img src={product.imagePath} alt={product.name} width="200" />
    </div>
  );
};

// ProductContainer to fetch individual product details
const ProductContainer = ({ products }) => {
  const { id } = useParams();
  const product = products.find((p) => p.id === parseInt(id)); // parse id to an integer

  return <Product product={product} />;
};

//Product Listing Component
// ProductList.js
const ProductList = ({ products }) => {
  return (
    <div>
      <h2>Product List</h2>
      <ul>
        {products.map((product) => (
          <li key={product.id}>
            <Link to={`/product/${product.id}`}>
              <strong>{product.name}</strong> - ${product.price}
            </Link>
            {/* <p>{product.description}</p>
            <img src={product.imagePath} alt={product.name} width="100" /> */}
          </li>
        ))}
      </ul>
    </div>
  );
};


//ProductForm for creating a new product 
// Best is to create the below in a file ProductForm.js
/*
const ProductForm = () => {
  const [product, setProduct] = useState({
    id: '',
    name: '',
    price: '',
    description: '',
    inStock: true,
    imagePath: ''
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setProduct((prevProduct) => ({
      ...prevProduct,
      [name]: value
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    // Convert the price to a number, just in case it's entered as a string
    const newProduct = { ...product, price: Number(product.price), id: Number(product.id) };

    fetch('http://localhost:5000/products', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(newProduct),
    })
      .then((response) => response.json())
      .then((data) => {
        console.log('Product created:', data);
        // Reset form after submission
        setProduct({
          id: '',
          name: '',
          price: '',
          description: '',
          inStock: true,
          imagePath: ''
        });
      })
      .catch((error) => console.error('Error creating product:', error));
  };

  return (
    <div>
       <h2 className="text-center mb-4">Create Product</h2>

      <div className="container mt-5">
      <div className="row justify-content-center">
        <div className="col-md-6">

      <form onSubmit={handleSubmit}>
        <div className="mb-4">
          <label className="form-label"> ID: </label>
          <input
            type="number"
            name="id"
            value={product.id}
            onChange={handleChange}
            required
          />
        </div>
        <div className="mb-4">
          <label>Name:</label>
          <input
            type="text"
            name="name"
            value={product.name}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label>Price:</label>
          <input
            type="number"
            name="price"
            value={product.price}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label>Description:</label>
          <textarea
            name="description"
            value={product.description}
            onChange={handleChange}
          ></textarea>
        </div>
        <div>
          <label>Image Path:</label>
          <input
            type="text"
            name="imagePath"
            value={product.imagePath}
            onChange={handleChange}
          />
        </div>
        <div>
          <label>
            <input
              type="checkbox"
              name="inStock"
              checked={product.inStock}
              onChange={(e) =>
                setProduct((prevProduct) => ({
                  ...prevProduct,
                  inStock: e.target.checked
                }))
              }
            />
            In Stock
          </label>
        </div>
        <button type="submit" class="btn btn-primary">Create Product</button>
      </form>
      </div>
      </div>
      </div>
    </div>
  );
};
*/

/*Formik Based forms */


// Validation Schema using Yup
const validationSchema = Yup.object({
  id: Yup.number().required('ID is required').positive('ID must be positive'),
  name: Yup.string().required('Product name is required'),
  price: Yup.number().required('Price is required').positive('Price must be positive'),
  description: Yup.string(),
  imagePath: Yup.string(),
  inStock: Yup.boolean()
});

const ProductForm = () => {
  const initialValues = {
    id: '',
    name: '',
    price: '',
    description: '',
    imagePath: '',
    inStock: true
  };

  const handleSubmit = (values, { resetForm }) => {
    fetch('http://localhost:5000/products', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(values),
    })
      .then((response) => response.json())
      .then((data) => {
        console.log('Product created:', data);
        resetForm(); // Reset form after successful submission
      })
      .catch((error) => console.error('Error creating product:', error));
  };

  return (
    <div className="container mt-4">
      <h2>Create Product</h2>
      <Formik
        initialValues={initialValues}
        validationSchema={validationSchema}
        onSubmit={handleSubmit}
      >
        {({ values, handleChange, handleSubmit }) => (
          <Form onSubmit={handleSubmit}>
            <div className="mb-3">
              <label htmlFor="id" className="form-label">ID:</label>
              <Field
                type="number"
                name="id"
                className="form-control"
              />
              <ErrorMessage name="id" component="div" className="text-danger" />
            </div>

            <div className="mb-3">
              <label htmlFor="name" className="form-label">Name:</label>
              <Field
                type="text"
                name="name"
                className="form-control"
              />
              <ErrorMessage name="name" component="div" className="text-danger" />
            </div>

            <div className="mb-3">
              <label htmlFor="price" className="form-label">Price:</label>
              <Field
                type="number"
                name="price"
                className="form-control"
              />
              <ErrorMessage name="price" component="div" className="text-danger" />
            </div>

            <div className="mb-3">
              <label htmlFor="description" className="form-label">Description:</label>
              <Field
                as="textarea"
                name="description"
                className="form-control"
              />
              <ErrorMessage name="description" component="div" className="text-danger" />
            </div>

            <div className="mb-3">
              <label htmlFor="imagePath" className="form-label">Image Path:</label>
              <Field
                type="text"
                name="imagePath"
                className="form-control"
              />
              <ErrorMessage name="imagePath" component="div" className="text-danger" />
            </div>

            <div className="form-check mb-3">
              <Field
                type="checkbox"
                name="inStock"
                className="form-check-input"
                checked={values.inStock}
                onChange={handleChange}
              />
              <label className="form-check-label" htmlFor="inStock">
                In Stock
              </label>
            </div>

            <button type="submit" className="btn btn-primary">Create Product</button>
          </Form>
        )}
      </Formik>
    </div>
  );
};


export default AppDemoRouter;
