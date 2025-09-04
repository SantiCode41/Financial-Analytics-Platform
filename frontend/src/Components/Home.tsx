interface HomeProps {
    data: { message: string };
}

function Home({ data }: HomeProps) {
    return <h1>{data.message}</h1>;
}

export default Home;