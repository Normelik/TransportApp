import { Link } from 'react-router-dom';

const NotFoundPage = () => {
  return (
    <div className="flex flex-col gap-1.5">
      <h1>404 Not found</h1>
      Oppps ... something went wrong ❌<Link to={'/home'}>Home</Link>
    </div>
  );
};

export default NotFoundPage;
